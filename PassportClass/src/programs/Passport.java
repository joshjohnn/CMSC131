package programs;

/**
 * This class represents a person's passport. It has three instance variables
 * representing the first, last and middle name (all are String variables). A
 * character instance variable representing a separator (to be used for
 * formatting purposes) is also part of the class. In addition, the class has a
 * StringBuffer instance variable that represents the passport stamps the person
 * has received.
 * 
 * For this class you need to define and use a private method called
 * validateAndFormat that takes a string as a parameter.
 * 
 * The class will keep track of the number of instances created by using a
 * private static field called objectCount.
 * 
 * @author CS
 *
 */
public class Passport {
	private String firstname;
	private String middlename;
	private String lastname;
	private char separator = ',';
	private StringBuffer stamps = new StringBuffer();
	private static int objectCount;

	public Passport(String firstname, String middlename, String lastname) {
		this.firstname = this.validateAndFormat(firstname);
		if (!middlename.isEmpty()) {
			this.middlename = this.validateAndFormat(middlename);
		}
		this.lastname = this.validateAndFormat(lastname);
		this.stamps = new StringBuffer();
		objectCount += 1;
	}

	public String toString() {

		StringBuffer strBuf = new StringBuffer();
		if (this.lastname != null && !this.lastname.trim().isEmpty()) {
			strBuf.append(this.lastname);
		}
		strBuf.append(separator);
		if (this.firstname != null && !this.firstname.trim().isEmpty()) {
			strBuf.append(this.firstname);
		}
		if (this.middlename != null && !this.middlename.trim().isEmpty()) {
			strBuf.append(separator);
			strBuf.append(this.middlename);
		}
		return strBuf.toString();
	}

	public Passport() {
		this.firstname = "Samplefirstname";
		this.middlename = "Samplemiddlename";
		this.lastname = "Samplelastname";
		objectCount += 1;

	}

	public Passport(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
		objectCount += 1;	
	}

	public Passport(Passport passport) {
		this(passport.firstname, passport.middlename, passport.lastname);
		objectCount += 1;
	}

	public Passport addStamp(String stamp) {
		if (stamp != null || !stamp.isEmpty()) {
			this.stamps.append(stamp);
		}
		return this;
	}

	public StringBuffer getStamps() {
		String stampCopy = this.stamps.toString();
		return new StringBuffer(stampCopy);
	}

	public char getSeparator() {
		return this.separator;
	}

	public boolean setSeparator(char separator) {
		if (separator != '@' && separator != ' ' && !Character.isLetter(separator) && !Character.isSpaceChar(separator)) {

			if (this.separator != separator) {
				this.separator = separator;
				return true;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Passport other = (Passport) obj;
		return (this.firstname.trim().equals(other.firstname.trim())
				&& this.lastname.trim().equals(other.lastname.trim())
				&& this.middlename.trim().equals(other.middlename.trim()));

	}

	public int compareTo(Passport passport) {
		if (passport == null) {
			return 1;
		}

		if (this.lastname.trim() == null && passport.lastname.trim() == null) {
			return 0;
		} else if (this.lastname.trim() == null) {
			return -1;
		} else if (passport.lastname.trim() == null) {
			return 1;
		}
		int lastNameCompare = this.lastname.trim().compareToIgnoreCase(passport.lastname.trim());

		if (lastNameCompare != 0) {
			return lastNameCompare;
		}

		if (this.firstname == null && passport.firstname == null) {
			return 0;
		} else if (this.firstname == null) {
			return -1;
		} else if (passport.firstname == null) {
			return 1;
		}

		int firstNameCompare = this.firstname.trim().compareToIgnoreCase(passport.firstname.trim());

		if (firstNameCompare != 0) {
			return firstNameCompare;
		}
		if (this.middlename == null && passport.middlename == null) {
			return 0;
		} else if (this.middlename == null) {
			return -1;
		} else if (passport.middlename == null) {
			return 1;
		}
		int middleNameCompare = this.middlename.trim().compareToIgnoreCase(passport.middlename.trim());

		if (middleNameCompare != 0) {
			return middleNameCompare;
		}
		return 0;
	}

	public static int getNumberOfPassportObjects() {
		return objectCount;
	}

	public static void resetNumberOfPassportObjects() {
		objectCount = 0;
	}

	public static Passport normalize(Passport passport, boolean uppercase) {

		if (passport == null) {
			return passport;
		}
		if (uppercase) {
			passport.firstname = passport.firstname.toUpperCase();
			passport.lastname = passport.lastname.toUpperCase();
			passport.middlename = passport.middlename.toUpperCase();
		} else {
			passport.firstname = passport.firstname.toLowerCase();
			passport.lastname = passport.lastname.toLowerCase();
			passport.middlename = passport.middlename.toLowerCase();
		}

		return passport;
	}

	public boolean changeLastname(String lastname) {
		boolean result = false;
		String newLastName = validateAndFormat(lastname);
		if (newLastName != null) {
			this.lastname = newLastName;
			result = this.lastname.equals(newLastName);
		}
		return result;
	}

	/*
	 * This method will generate and return a formatted string in lowercase with the
	 * first character in uppercase. The parameter is valid if it is not null and it
	 * is not blank according to the string method isBlank(). If the parameter is
	 * invalid, the method will return null and perform no further processing. If
	 * the parameter is valid, spaces surrounding the parameter will be removed, the
	 * string will be converted to lowercase, and the first character of the string
	 * (after spaces have been removed) will be in upper case. The following methods
	 * can be helpful during the implementation of this method:
	 * Character.toUpperCase, and the string methods charAt and substring.
	 * 
	 * You can test this method by initially defining it public; once you have
	 * tested it, make it private.
	 * 
	 */
	private static String validateAndFormat(String name) {

		boolean isValid = name != null && !name.trim().isBlank();
		String result = null;
		if (!isValid) {
			return result;
		}
		if (isValid) {
			result = name.trim().toLowerCase();
			result = Character.toUpperCase(result.charAt(0)) + result.substring(1);
		}
		return result;
	}
}
