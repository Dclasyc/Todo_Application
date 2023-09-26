package com.dclasyc.springboot.myspringwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("username")
public class TodoControllerJPA {

    public TodoControllerJPA(TodoRepository todoRepository) {

        this.todoRepository = todoRepository;
    }

    private TodoRepository todoRepository;

    @RequestMapping(value = "list-todos", method = RequestMethod.GET)
    public String listAllTodos(ModelMap model) {
        String username = getLoggedInUsername(model);
        List<Todo> todos = todoRepository.findTodoByUsername(username);
        model.addAttribute("todoList", todos);
            return "listTodos";
    }



    @RequestMapping(value ="add-todo", method = RequestMethod.GET)
        public String showNewTodoPage(ModelMap model) {
        String username = getLoggedInUsername(model);
        Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
            return "addTodo";
    }

    @RequestMapping(value ="add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

        if(result.hasErrors()){
            return "addTodo";
        }
        String username = getLoggedInUsername(model);
        todo.setUsername(username);
        todoRepository.save(todo);

//        todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(),todo.isDone());

        return "redirect:list-todos";

    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id) {

        //implement service class
        todoRepository.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value ="update-todo", method = RequestMethod.GET)
    public String showUpdateTodo(@RequestParam int id, ModelMap model) {

        Optional<Todo> todo = todoRepository.findById(id);
        model.addAttribute("todo", todo );
        return "updateTodo";
    }

    @RequestMapping(value ="update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

        if(result.hasErrors()){
            return "updateTodo";
        }

        String username = getLoggedInUsername(model);
        todo.setUsername(username);
        todoRepository.save(todo);
        return "redirect:list-todos";

    }

    private static String getLoggedInUsername(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}


