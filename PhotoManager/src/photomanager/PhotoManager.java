package photomanager;

import java.io.*;
import java.util.*;

/**
 * The PhotoManager class keeps track of Photos by using an ArrayList of Photo
 * references. The class relies heavily on ArrayList methods. At least you will
 * be using the following ArrayList methods: add, get, remove, clear. Check the
 * Java API ArrayList entry for information about each of these methods.
 * 
 * @author UMCP CS Department
 *
 */
public class PhotoManager {
	private ArrayList<Photo> allPhotos;

	/**
	 * Assigns to the allPhotos instance variable an ArrayList of Photos.
	 */
	public PhotoManager() {
		allPhotos = new ArrayList<>();
	}

	/**
	 * Creates a Photo based on the provided parameters and adds the photo to the
	 * allPhotos ArrayList. The photo will be added if it does not already exist in
	 * the ArrayList (hint: use the findPhoto method). The method must handle
	 * (try/catch block) any exception thrown by creating a Photo (remember that a
	 * Photo constructor can throw an IllegalArgumentException). If an exception is
	 * thrown by the Photo constructor, the photo will not be added; in addition the
	 * message "addPhoto: Invalid arguments" will be printed to standard error (that
	 * means using System.err.println (notice the err)) and false will be returned.
	 * If a photo is added the method will return true.
	 * 
	 * @param photoSource Photo's url or filename.
	 * @param width       Photo's width in pixels.
	 * @param height      Photo's height in pixels.
	 * @param date        Date the photo was taken.
	 * @return true if photo added; false otherwise.
	 */
	public boolean addPhoto(String photoSource, int width, int height, String date) {
		try {
			Photo newPhoto = new Photo(photoSource, width, height, date);
			int photoIndex = findPhoto(photoSource);

			if (photoIndex == -1) {
				allPhotos.add(newPhoto);
				return true;
			}
		} catch (IllegalArgumentException e) {
			System.err.println("addPhoto: Invalid arguments");
		}

		return false;
	}

	/**
	 * Returns a string where each Photo is printed on a line by itself.
	 * 
	 * @return String with information about all photos.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (Photo photo : allPhotos) {
			sb.append(photo).append("\n");
		}

		return sb.toString();
	}

	/**
	 * Returns the index in the ArrayList associated with the Photo that has a
	 * photoSource corresponding to the parameter. The method will return -1 if no
	 * photo is found or if the parameter is null.
	 * 
	 * @param photoSource Photo's photoSource.
	 * @return Index in the array or -1 (photo not found).
	 */
	public int findPhoto(String photoSource) {
		for (int i = 0; i < allPhotos.size(); i++) {
			if (allPhotos.get(i).getPhotoSource().equals(photoSource)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Adds the specified comment to the photo with the specified photoSource (if
	 * such photo is present in allPhotos). It returns true if the comments are
	 * added and false if the photo could not be found, or if the parameters are
	 * invalid. A parameter is invalid if it is null or if the newComment string is
	 * blank (according to the String method isBlank()).
	 * 
	 * @param photoSource PhotoSource of photo we would like to add the comment.
	 * @param newComment  Comment to add.
	 * @return true if comment added; false otherwise.
	 */
	public boolean addComment(String photoSource, String newComment) {
		if (photoSource == null || newComment == null || newComment.isBlank()) {
			return false;
		}

		for (Photo photo : allPhotos) {
			if (photo.getPhotoSource().equals(photoSource)) {
				photo.addComments(newComment);
				return true;
			}
		}

		return false;
	}

	/**
	 * Returns the comments of the photo associated with the specified photoSource.
	 * The method will return null if no photo exists with the specified
	 * photoSource, or if the parameter is null.
	 * 
	 * @param photoSource photo to find comments for.
	 * @return Comments or null.
	 */
	public String getComments(String photoSource) {
		if (photoSource == null) {
			return null;
		}
		for (Photo photo : allPhotos) {
			if (photoSource.equals(photo.getPhotoSource())) {
				return photo.getComments();
			}
		}
		return null;
	}

	/**
	 * Removes all the photos from allPhotos. This method only takes a single line
	 * of code.
	 */
	public void removeAllPhotos() {
		allPhotos.clear();
	}

	/**
	 * Removes the Photo with the specified photoSource (if it exists). Returns true
	 * if the photo was removed and false if the photo was not found or the
	 * parameter is null. Remember that you can remove elements from an ArrayList
	 * using the ArrayList remove method.
	 * 
	 * @param photoSource Photo we would like to remove.
	 * @return true if photo was removed; false otherwise.
	 */
	public boolean removePhoto(String photoSource) {
		if (photoSource == null) {
			return false;
		}

		for (int i = allPhotos.size() - 1; i >= 0; i--) {
			Photo photo = allPhotos.get(i);
			if (photo.getPhotoSource().equals(photoSource)) {
				allPhotos.remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * Loads the photos specified in filename to the allPhotos ArrayList. It adds to
	 * the ArrayList (it does not clear the ArrayList before adding photos). Each
	 * line of the file will have information about a photo. The information will be
	 * the photoSource, followed by the width, height and date. You can assume the
	 * file will have correct information. The following is an examples of a file
	 * entry: <br>
	 * umcp/college1.jpg 300 400 10/18/2020-17:10 <br>
	 * If an error takes place while opening the file (e.g., file does not exist),
	 * an error message (any message is fine) will be printed using
	 * System.err.println. Notice that your code will not crash when a file could
	 * not be opened; in this case the method will print the error message and
	 * return false. The method will return false and perform no processing when the
	 * parameter is null.
	 * 
	 * @param filename Name of file with information about photos.
	 * @return true if the data was loaded and false otherwise.
	 * 
	 */
	public boolean loadPhotos(String filename) {
		boolean loaded = false;
		try {
			FileReader fileReader = new FileReader(new File(filename));
			Scanner sc = new Scanner(fileReader);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] parts = line.split(" ");
				allPhotos.add(new Photo(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), parts[3]));
			}
			loaded = true;
			sc.close();
			fileReader.close();
		} catch (FileNotFoundException fne) {
			System.err.println("File not found: " + fne);
		} catch (IOException e) {
			System.err.println("Error reading file: " + e);
		}
		return loaded;
	}

	/**
	 * Sorts the allPhotos by date. This method requires a single line of code.
	 */
	public void sortPhotosByDate() {

		Collections.sort(allPhotos);
	}

	/**
	 * This method creates an HTML file with all the photos. This method has been
	 * implemented for you and it is not used by any other method.
	 * 
	 * @param htmlFilename Web page with photos.
	 */
	public void createHTMLPage(String htmlFilename) {
		String body = "";

		for (Photo photo : allPhotos) {
			body += "<img src=\"" + photo.getPhotoSource() + "\" ";
			body += "width=\"" + photo.getWidth() + "\" ";
			body += "height=\"" + photo.getHeight() + "\" ";
			body += "alt=\"photo image\"><br>\n";
		}

		Utilities.generateHTMLPageWithBody(htmlFilename, body);
	}
}