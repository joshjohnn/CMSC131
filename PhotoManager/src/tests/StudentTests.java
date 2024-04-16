package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import photomanager.Photo;
import photomanager.PhotoManager;

public class StudentTests {

	@Test
	public void testAddValidPhoto() {
		PhotoManager manager = new PhotoManager();
		assertTrue(manager.addPhoto("path/photo.jpg", 500, 300, "01/01/2022"));
	}

	@Test
	public void testAddInvalidPhoto() {
		PhotoManager manager = new PhotoManager();
		assertFalse(manager.addPhoto(null, 500, 300, "01/01/2022"));
	}

	@Test
	public void testAddDuplicatePhoto() {
		PhotoManager manager = new PhotoManager();
		manager.addPhoto("path/photo.jpg", 500, 300, "01/01/2022");
		assertFalse(manager.addPhoto("path/photo.jpg", 500, 300, "01/01/2022"));
	}

	@Test
	public void testToString() {
		PhotoManager manager = new PhotoManager();
		manager.addPhoto("path/photo.jpg", 500, 300, "01/01/2022");
		String expected = "path/photo.jpg,500,300,01/01/2022\n";
		assertEquals(expected, manager.toString());
	}

	@Test
	public void testFindPhotoExists() {
		PhotoManager manager = new PhotoManager();
		manager.addPhoto("path/photo.jpg", 500, 300, "01/01/2022");
		int index = manager.findPhoto("path/photo.jpg");
		assertNotEquals(-1, index);
	}

	@Test
	public void testFindPhotoNotExists() {
		PhotoManager manager = new PhotoManager();
		int index = manager.findPhoto("path/nonexistent.jpg");
		assertEquals(-1, index);
	}

	@Test
	public void testAddCommentToPhoto() {
		PhotoManager manager = new PhotoManager();
		manager.addPhoto("path/photo.jpg", 500, 300, "01/01/2022");
		assertTrue(manager.addComment("path/photo.jpg", "Beautiful scenery"));
	}

	@Test
	public void testRemoveExistingPhoto() {
		PhotoManager manager = new PhotoManager();
		manager.addPhoto("path/photo.jpg", 500, 300, "01/01/2022");
		assertTrue(manager.removePhoto("path/photo.jpg"));
	}

	@Test
	public void testPhotoCopyConstructor() {
		Photo original = new Photo("path/photo.jpg", 500, 300, "01/01/2022");
		Photo copy = new Photo(original);
		assertEquals(original.toString(), copy.toString());
	}

	@Test
	public void testGetCommentsOfNonExistingPhoto() {
		PhotoManager manager = new PhotoManager();
		assertNull(manager.getComments("path/nonexistent.jpg"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPhotoConstructorInvalidArguments() {
		new Photo(null, -1, -1, null);
	}
}
