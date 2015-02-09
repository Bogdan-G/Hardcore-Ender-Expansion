package chylex.hee.render.json;
import com.google.common.base.Joiner;

public final class JsonRenderPatterns{
	public static final JsonRenderPatterns ITEM_DEFAULT = new JsonRenderPatterns(new String[]{
		"{",
		"    'parent': 'builtin/generated',",
		"    'textures': {",
		"        'layer0': '$0'",
		"    },",
		"    'display': {",
		"        'thirdperson': {",
		"            'rotation': [ -90, 0, 0 ],",
		"            'translation': [ 0, 1, -3 ],",
		"            'scale': [ 0.55, 0.55, 0.55 ]",
		"        },",
		"        'firstperson': {",
		"            'rotation': [ 0, -135, 25 ],",
		"            'translation': [ 0, 4, 2 ],",
		"            'scale': [ 1.7, 1.7, 1.7 ]",
		"        }",
		"    }",
		"}"
	});
	
	public final String contents;
	
	private JsonRenderPatterns(String[] fileData){
		contents = Joiner.on(System.getProperty("line.separator")).join(fileData).replace('\'','"');
	}
	
	public String generate(Object...data){
		String text = contents;
		for(int a = data.length-1; a >= 0; a--)text = text.replace("$"+a,data[a] == null ? "null" : String.valueOf(data[a]));
		return text;
	}
}
