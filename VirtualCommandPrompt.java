import java.util.List;
import java.util.Scanner;

/**
 * This class is use to perform all task on virtual command prompt 
 * @author Rachna Jadam
 *
 */
public class VirtualCommandPrompt {

    static Tree tree;
    static Node currentDirectory;

    public static void main(String arg[]) {
        tree = new Tree();
        String inputCommand = "";
        String command[];
        @SuppressWarnings("resource")
        Scanner scannerInstance = new Scanner(System.in);
        String show = "R:\\>";
        String path = "";
        currentDirectory = Tree.root;
        System.out.print(show);
        do {
            inputCommand = scannerInstance.nextLine();
            command = inputCommand.split(" ");
            inputCommand = command[0];

            switch (inputCommand) {
	            case "mkdir": 
	                if (command.length < 2) {
	                    System.out.println("The syntax of the command is incorrect.");
	                } else {
	                    path = getPath(show, command[1]);
	                    mkdir(path);
	                }
	                break;
	                
	            case "cd":
	                if (command.length < 2) {
	                    System.out.println("The syntax of the command is incorrect.");
	                } else {
	                    path = getPath(show, command[1]);
	                    if (cd(path) != null) {
	                        currentDirectory = cd(path);
	                        show = path + ">";
	                    } else {
	                        System.out.println("The system cannot find the path specified.");
	                    }
	                }
	                break;
	                
	            case "bk":
	                if (!("R:\\>".equals(show))) {
	                    path = (show.substring(0, show.length() - 1));
	                    show = path.substring(0, path.lastIndexOf("\\")) + ">";
	                    currentDirectory = tree.setCurrentDirectory(show.substring(0, show.length() - 1));
	                    if ("R:>".equals(show)) {
	                        show = "R:\\>";
	                        currentDirectory = Tree.root;
	                    }
	                }
	                break;
	                
	            case "ls":
	                path = getPath(show, null);
	                ls(path);
	                break;
	                
	            case "find":
	                if (command.length < 2) {
	                    System.out.println("The syntax of the command is incorrect.");
	                } else {
	                    path = getPath(show, command[1]);
	                    List<String> pathList = tree.findDirectory(currentDirectory, command[1]);
	                    if (pathList.size() == 0) {
	                        System.out.println(command[1] + " not found");
	                    } else {
	                        for (String directoryPath : pathList) {
	                            System.out.println("."+ directoryPath.substring(currentDirectory
                                        .getDirectoryPath().length() - 1,directoryPath.length()));
	                        }
	                    }
	                }
	                break;
	                
	            case "tree":
	                tree();
	                break;
	                
	            case "exit":
	                System.exit(0);
	                
	            default:
	                System.out.println("'"+ inputCommand+ "' is not recognized as an internal or external command,"+
	                        "\noperable program or batch file.");
	        }
            System.out.print(show);
                
        } while (true);
    }

    /**
     * mkdir is use to create directory
     * @param path it is path or name of directory
     */
    private static void mkdir(String path) {
        tree.addDirectory(path);
    }

    /**
     * cd is use for change directory 
     * @param path
     * @return Node of the present current directory (after cd)
     */
    private static Node cd(String path) {
        return tree.setCurrentDirectory(path);
    }

    /**
     * ls is use to listing of directories
     * @param path it is path or name of directory
     */
    private static void ls(String path) {
        Node lsNode = tree.getNode(path);
        int directoryCount = 0;
        for (Node childNode : lsNode.getChildNodeList()) {
            System.out.println(childNode.getCreationDateAndTime() + "    "+ childNode.getDirectoryName());
            directoryCount++;
        }
        System.out.println("    " + directoryCount + " Folder(s)");
    }
    
    /**
     * It is use to show all directories and sub-directories present in current directory
     * @return
     */
    private static void tree() {
        List<String> pathList = tree.traverseTree(currentDirectory);
        for (String path : pathList) {
            System.out.println("."+ path.substring(currentDirectory.getDirectoryPath().length() - 1, path.length()));
        }
    }

    /**
     * Use to get path with the help of command argument
     * @param path
     * @param commandArgument
     * @return
     */
    private static String getPath(String path, String commandArgument) {
        if (commandArgument == null) {
            if ("R:\\>".equals(path)) {
                return (path.substring(0, path.length() - 2));
            } else {
                return (path.substring(0, path.length() - 1));
            }
        } else {
            if ("R:\\>".equals(path)) {
                return (path.substring(0, path.length() - 2)) + "\\"+ commandArgument;
            } else {
                return (path.substring(0, path.length() - 1)) + "\\"+ commandArgument;
            }
        }
    }
}
