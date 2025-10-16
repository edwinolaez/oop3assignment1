package appDomain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import shapes.*;
import utilities.BaseAreaComparator;
import utilities.Sorting;
import utilities.VolumeComparator;

/**
 * <p>
 * This application driver code is designed to be used as a basis for the
 * Complexity and Sorting assignment that will be developed in the CPRG304 
 * F2025 class at SAIT. The implementors of this applications will be required
 * to add all the correct functionality.
 * </p>
 */
public class AppDriver
{
	/**
	 *  The main method is the entry point of the application.
	 *  
	 *  @param args The input to control the execution of the application.
	 */
	public static void main( String[] args )
	{
		String filePath = null;
        String sortType = null;
        String sortAlgorithm = null;

        // Parse command-line arguments
        for (int i = 0; i < args.length; i++) {
            String arg = args[i].toLowerCase();
            switch (arg) {
                case "-f":
                case "-F":
                    if (i + 1 < args.length) {
                        filePath = args[++i];
                    }
                    break;
                case "-t":
                case "-T":
                    if (i + 1 < args.length) {
                        sortType = args[++i].toLowerCase();
                    }
                    break;
                case "-s":
                case "-S":
                    if (i + 1 < args.length) {
                        sortAlgorithm = args[++i].toLowerCase();
                    }
                    break;
            }
        }

        // Check if essential arguments are provided
        if (filePath == null || sortType == null || sortAlgorithm == null) {
            System.out.println("Usage: java -jar sort.jar -f<file_path> -t<sort_type> -s<sort_algorithm>");
            System.out.println("  -f, -F: File path");
            System.out.println("  -t, -T: Sort type (h = height, v = volume, a = base area)");
            System.out.println("  -s, -S: Sort algorithm (b = bubble, s = selection, i = insertion, m = merge, q = quick, z = custom)");
            return;
        }

		ArrayList<Shape> shapeList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            int numShapes = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < numShapes; i++) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                String shapeName = parts[0];
                double height = Double.parseDouble(parts[1]);
                double value = Double.parseDouble(parts[2]);

                Shape shape = null;
                switch (shapeName) {
                    case "Cylinder":
                        shape = new Cylinder(height, value);
                        break;
                    case "Cone":
                        shape = new Cone(height, value);
                        break;
                    case "Pyramid":
                        shape = new Pyramid(height, value);
                        break;
                    case "SquarePrism":
                        shape = new SquarePrism(height, value);
                        break;
                    case "TriangularPrism":
                        shape = new TriangularPrism(height, value);
                        break;
                    case "PentagonalPrism":
                        shape = new PentagonalPrism(height, value);
                        break;
                    case "OctagonalPrism":
                        shape = new OctagonalPrism(height, value);
                        break;
                }
                if (shape != null) {
                    shapeList.add(shape);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found at path '" + filePath + "'. Please check the file path and try again.");
            return;
        } catch (Exception e) {
            System.out.println("Error: An error occurred while reading or parsing the file. Please ensure the file is correctly formatted.");
            return;
        }

        Shape[] shapes = shapeList.toArray(new Shape[0]);
        Comparator<Shape> comparator = null;

        switch (sortType) {
            case "a":
                comparator = new BaseAreaComparator();
                break;
            case "v":
                comparator = new VolumeComparator();
                break;
            case "h":
				comparator = new HeightComparator();
            default:

                break;
        }

        long startTime = System.Time();

        switch (sortAlgorithm) {
            case "s":
                Sorting.selectionSort(shapes, comparator);
                break;
            case "m":
                Sorting.mergeSort(shapes, comparator);
                break;
            // case "b": Sorting.bubbleSort(shapes, comparator); break;
            // case "i": Sorting.insertionSort(shapes, comparator); break;
            // case "q": Sorting.quickSort(shapes, comparator); break;
            // case "z": Sorting.customSort(shapes, comparator); break;
            default:
                System.out.println("Error: Unknown sort algorithm '" + sortAlgorithm + "'.");
                return;
        }

        long endTime = System.Time();
        long duration = (endTime - startTime);

        System.out.println("Sorting finished in " + duration + " seconds.");


		// TODO Auto-generated method stub

		// refer to demo00 BasicFileIO.java for a simple example on how to
		// read data from a text file

		// refer to demo01 Test.java for an example on how to parse command
		// line arguments and benchmarking tests

		// refer to demo02 Student.java for comparable implementation, and
		// NameCompare.java or GradeCompare for comparator implementations

		// refer to demo02 KittySort.java on how to use a custom sorting
		// algorithm on a list of comparables to sort using either the
		// natural order (comparable) or other orders (comparators)

	}

}
