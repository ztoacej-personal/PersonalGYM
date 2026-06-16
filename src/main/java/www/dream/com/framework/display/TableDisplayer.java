package www.dream.com.framework.display;

import java.lang.reflect.Field;
import java.util.List;

import www.dream.com.framework.display.Caption.WhenUse;

public class TableDisplayer {
	public static String displayHeader(Class<?> targetClass) {
		StringBuilder sb = new StringBuilder("<tr>");
		List<Field> listField = ClassUtil.getListField(targetClass, Caption.class);
		for (Field field : listField) {
			Caption annoCaption = field.getAnnotation(Caption.class);
			if (WhenUse.isTableTarget(annoCaption.whenUse())) {
				sb.append("<th>").append(annoCaption.caption()).append("</th>");
			}
		}

		sb.append("</tr>");
		return sb.toString();
	}

	public static String displayBody() {
		return "<tr>......</tr>";
	}
}
