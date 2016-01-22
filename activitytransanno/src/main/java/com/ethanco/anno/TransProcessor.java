package com.ethanco.anno;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;

/**
 * @Description TODO
 * Created by YOLANDA on 2016-01-21.
 */
@SupportedAnnotationTypes({"com.ethanco.anno.ActivityTransition"})
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class TransProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        List<ProxyInfo> proxyInfoList = new ArrayList<>();

        for (Element ele : roundEnv.getElementsAnnotatedWith(ActivityTransition.class)) {
            if (ele.getKind() == ElementKind.CLASS) {
                //CLASS
                TypeElement classElement = (TypeElement) ele;
                PackageElement packageElement = (PackageElement) ele.getEnclosingElement();
                String fqClassName = classElement.getQualifiedName().toString();
                String className = classElement.getSimpleName().toString();
                String packageName = packageElement.getQualifiedName().toString();
                ActivityTransition activityTransition = classElement.getAnnotation(ActivityTransition.class);
                Transition allTrans = activityTransition.value(); // layoutId

                TransitionBean transitionBean = new TransitionBean();
                transitionBean.setAllTransition(allTrans);
                ProxyInfo proxyInfo = new ProxyInfo(packageName, className);
                proxyInfo.setTypeElement(classElement);
                proxyInfo.setTransitionBean(transitionBean);

                proxyInfoList.add(proxyInfo);
                processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "annatated class : packageName = " + packageName + " , className = " + className + " , fqClassName = " + fqClassName);
            } else if (ele.getKind() == ElementKind.FIELD) {
                //FIELD
            }
        }

        for (ProxyInfo proxyInfo : proxyInfoList) {
            try {
                JavaFileObject jfo = processingEnv.getFiler().createSourceFile(proxyInfo.getProxyClassFullName(), proxyInfo.getTypeElement());
                Writer writer = jfo.openWriter();
                writer.write(proxyInfo.generateJavaCode());
                writer.flush();
                writer.close();
            } catch (IOException e) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, e.getMessage());
            }
        }
        return true;
    }
}
