import java.util.Scanner;

public class VirtualCommandPrompt {

	static Tree tree;

	public static void main(String arg[]) {
		tree = new Tree();
		String inputCommand = "";
		String command[];
		Scanner scannerInstance = new Scanner(System.in);
		String show = "R:\\>";
		String path = "";
		System.out.print(show);
		do {
			inputCommand = scannerInstance.nextLine();
			command = inputCommand.split(" ");

			inputCommand = command[0];

			if ("mkdir".equals(inputCommand)) {
				if (command.length < 2) {
					System.out
							.println("The syntax of the command is incorrect.");
				} else {
					path = getPath(show, command[1]);
					mkdir(path);
				}

			} else if ("cd".equals(inputCommand)) {
				if (command.length < 2) {
					System.out
							.println("The syntax of the command is incorrect.");
				} else {
					path = getPath(show, command[1]);
					if (cd(path)) {
						show = path + ">";
					} else {
						System.out
								.println("The system cannot find the path specified.");
					}
				}

			} else if ("bk".equals(inputCommand)) {
				if (!("R:\\>".equals(show))) {
					path = (show.substring(0, show.length() - 1));
					show = path.substring(0, path.lastIndexOf("\\")) + ">";
					if ("R:>".equals(show)) {
						show = "R:\\>";
					}
				}
			} else if ("ls".equals(inputCommand)) {
				path = getPath(show, null);
				ls(path);
			} else if ("find".equals(inputCommand)) {
				find();
			} else if ("tree".equals(inputCommand)) {
				tree();
			} else if ("exit".equals(inputCommand)) {
				break;
			} else {
				System.out
						.println("'"
								+ inputCommand
								+ "' is not recognized as an internal or external command,\noperable program or batch file.");
			}
			System.out.print(show);

		} while (true);
	}

	private static void mkdir(String path) {
		tree.addDirectory(path);
	}

	private static boolean cd(String path) {
		return tree.isPathExistOrNot(path);
	}

	private static void ls(String path) {
		Node lsNode = tree.getNode(path);
		int directoryCount = 0;
		for (Node childNode : lsNode.getChildNodeList()) {
			System.out.println(childNode.getCreationDateAndTime() + "    "
					+ childNode.getDirectoryName());
			directoryCount++;
		}
		System.out.println("    " + directoryCount + " Folder(s)");
	}

	private static void find() {

	}

	private static boolean tree() {
		return true;
	}

	private static String getPath(String path, String commandArgument) {
		if (commandArgument == null) {
			if ("R:\\>".equals(path)) {
				return (path.substring(0, path.length() - 2));
			} else {
				return (path.substring(0, path.length() - 1));
			}
		} else {
			if ("R:\\>".equals(path)) {
				return (path.substring(0, path.length() - 2)) + "\\"
						+ commandArgument;
			} else {
				return (path.substring(0, path.length() - 1)) + "\\"
						+ commandArgument;
			}
		}

	}
}
