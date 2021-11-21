package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		Class<RichSoilLand> clazz = RichSoilLand.class;
		Field[] declaredFields = clazz.getDeclaredFields();

		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();

		Predicate<Field> getPublicFields = field -> Modifier.isPublic(field.getModifiers());
		Predicate<Field> getPrivateFields = field -> Modifier.isPrivate(field.getModifiers());
		Predicate<Field> getProtectedFields = field -> Modifier.isProtected(field.getModifiers());

		while(!input.equals("HARVEST")){
			switch (input) {
				case "public":
					getFieldStream(declaredFields)
							.filter(getPublicFields)
							.forEach(Main::printField);
					break;
				case "private":
					getFieldStream(declaredFields)
							.filter(getPrivateFields)
							.forEach(Main::printField);
					break;
				case "protected":
					getFieldStream(declaredFields)
							.filter(getProtectedFields)
							.forEach(Main::printField);
					break;
				case "all":
					getFieldStream(declaredFields).forEach(Main::printField);
					break;
			}

			input = scan.nextLine();
		}
	}

	private static void printField(Field field) {
		System.out.printf("%s %s %s%n",
				Modifier.toString(field.getModifiers()),
				field.getType().getSimpleName(),
				field.getName());
	}

	private static Stream<Field> getFieldStream(Field[] fieldsArray) {
		return Arrays.stream(fieldsArray);
	}
}
