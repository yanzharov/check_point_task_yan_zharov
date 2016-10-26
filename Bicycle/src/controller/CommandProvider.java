package controller;

import command.Command;
import command.impl.AddNewProduct;
import command.impl.DeleteProduct;
import command.impl.FindProducts;
import command.impl.GetCount;
import command.impl.GetMax;
import command.impl.GetMin;
import java.util.HashMap;
import java.util.Map;
import command.impl.EditProduct;

public class CommandProvider {
    private Map<String, Command> commands = new HashMap<String, Command>();
	
    CommandProvider() {// класс public, конструктор (единственный) friendly - над кем так издеваемся?
	commands.put("ADD_NEW_PRODUCT", new AddNewProduct());
	commands.put("DELETE_PRODUCT", new DeleteProduct());
	commands.put("EDIT_PRODUCT", new EditProduct());
        commands.put("GET_COUNT", new GetCount());
        commands.put("GET_MAX", new GetMax());
        commands.put("GET_MIN", new GetMin());
        commands.put("FIND_PRODUCTS", new FindProducts());
    }
	
    public Command getCommand(String commandName){
	Command command;
	command = commands.get(commandName);
	return command;
    }
    
}
