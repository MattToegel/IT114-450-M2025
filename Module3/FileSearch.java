package Module3;

import java.io.File;

public class FileSearch {
    public static void main(String[] args) {
        // Check if at least the directory path is provided
        if (args.length == 0) {
            System.out.println("Usage: java FileSearch <directory_path> [partial_filename] [file_extension]");
            return;
        }

        // Get the directory path from the first command-line argument
        String directoryPath = args[0];
        // Get the partial file name match from the second argument if provided
        String partialFileName = (args.length > 1) ? args[1] : "";
        // Get the file extension from the third argument if provided, otherwise search
        // for all extensions
        String fileExtension = (args.length > 2) ? args[2] : "";

        // Create a File object for the provided directory
        File directory = new File(directoryPath);

        // Check if the directory exists and is valid
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory: " + directoryPath);
            return;
        }

        // Start searching for files
        searchFiles(directory, partialFileName, fileExtension);
    }

    // Recursive method to search for files with the given partial name and
    // extension
    public static void searchFiles(File dir, String partialName, String extension) {
        // Get the list of files in the current directory
        File[] files = dir.listFiles();

        // Check if the directory is empty or if an error occurred while reading
        if (files == null) {
            System.out.println("Unable to access directory: " + dir.getAbsolutePath());
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                // Recursively search subdirectories
                searchFiles(file, partialName, extension);
            } else {
                // Check if the file matches the partial name (if specified)
                boolean matchesName = partialName.isEmpty() || file.getName().contains(partialName);
                // Check if the file matches the given extension (or no extension is specified)
                boolean matchesExtension = extension.isEmpty() || file.getName().endsWith(extension);

                // Print the file path if it matches both criteria
                if (matchesName && matchesExtension) {
                    System.out.println("Found: " + file.getAbsolutePath());
                }
            }
        }
    }
}