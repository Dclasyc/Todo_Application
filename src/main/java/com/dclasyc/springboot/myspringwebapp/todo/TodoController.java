package com.dclasyc.springboot.myspringwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("username")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping(value = "list-todos", method = RequestMethod.GET)
    public String listAllTodos(ModelMap model) {

        List<Todo> todos = todoService.findTodoByUsername("Dclasyc");
        model.addAttribute("todoList", todos);
            return "listTodos";
    }

    @RequestMapping(value ="add-todo", method = RequestMethod.GET)
        public String showNewTodoPage(ModelMap model) {
        String username = (String)model.get("username");
        Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
            return "addTodo";
    }

    @RequestMapping(value ="add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

        if(result.hasErrors()){
            return "addTodo";
        }

        String username = (String)model.get("username");
        todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(),false);

        return "redirect:list-todos";

    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id) {

        //implement service class
        todoService.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value ="update-todo", method = RequestMethod.GET)
    public String showUpdateTodo(@RequestParam int id, ModelMap model) {

        Todo todo = todoService.findById(id);
        model.addAttribute("todo", todo );
        return "updateTodo";
    }

    @RequestMapping(value ="update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

        if(result.hasErrors()){
            return "updateTodo";
        }

        String username = (String)model.get("username");
        todo.setUsername(username);
        todoService.updateTodo(todo);
        return "redirect:list-todos";

    }

}


