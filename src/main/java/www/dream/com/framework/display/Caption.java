package www.dream.com.framework.display;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
public @interface Caption {
	public enum WhenUse {
		all, detail, list, none;
		
		public static boolean isTableTarget(WhenUse whenUse) {
			if (whenUse == all || whenUse == list)
				return true;
			return false;
		}
	};
	
	public WhenUse whenUse();
	public String caption();
	
}
