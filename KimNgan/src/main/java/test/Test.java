package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;

public class Test {
	public static void main(String[] args) throws Exception {
		ParseResult<CompilationUnit> parseResult = null;
		FileInputStream in = new FileInputStream("T:\\LeThiKimNgan\\KimNgan\\src\\main\\java\\models\\Customer.java");
		try {
			JavaParser parser = new JavaParser();
			parseResult = parser.parse(in);
			
			Optional<CompilationUnit> optional = parseResult.getResult();
			if(optional.isPresent()) {
				CompilationUnit cu = optional.get();
				getFields(cu);
				System.out.println("===========================");
				getMethods(cu);
			}
			
		}finally {
			in.close();
		}
	}

	void x(String folderName) throws Exception {
		File folder = new File(folderName);
		File [] files = folder.listFiles();
		for(File file : files) {
//			if(file.isDirectory())
//				x(file.toString());
			System.out.println(file.getAbsolutePath());
		}
	}
	
	public static void getMethods(CompilationUnit cu) {
		List<MethodDeclaration> methods = cu.findAll(MethodDeclaration.class);
		for(MethodDeclaration methodDeclaration : methods) {
			System.out.println(methodDeclaration.getName());
		}
		
	}

	public static void getFields(CompilationUnit cu) {
		List<FieldDeclaration> fileds = cu.findAll(FieldDeclaration.class);
		for(FieldDeclaration fieldDeclaration : fileds) {
			System.out.println(fieldDeclaration);
		}
		
	}
}
