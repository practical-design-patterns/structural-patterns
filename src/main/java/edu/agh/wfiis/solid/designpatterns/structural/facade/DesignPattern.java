package edu.agh.wfiis.solid.designpatterns.structural.facade;

public class DesignPattern {

    private final String name;

    private final RunnableCode patternCode;


    public RunnableCode refactor(String badCode) {
        return patternCode.run(badCode);
    }

    public DesignPattern(String name, RunnableCode patternCode) {
        this.name = name;
        this.patternCode = patternCode;

        RuntimeEnvironmentCreator.create();
        RuntimeEnvironmentConfigurer.configure();
        RuntimeEnvironmentDependenciesConfigurer.configure();
        RuntimeEnvironmentActivator.activate();
    }

    public static void main(String args[]){
        DesignPattern designPattern = new DesignPattern("facade", new RunnableCode() {
            @Override
            public RunnableCode run(String code) {
                return null;
            }
        });
    }
}

//required dependencies, put here only to compile project
interface RunnableCode {
    RunnableCode run(String code);
}

//some dependencies to 3rd party library
class RuntimeEnvironmentConfigurer{
    static void configure(){
        //magic happens here
    }
}

class RuntimeEnvironmentActivator{
    static void activate(){
        //magic happens here
    }
}

class RuntimeEnvironmentCreator{
    static void create(){
        //magic happens here
    }
}

class RuntimeEnvironmentDependenciesConfigurer{
    static void configure(){
        //magic happens here
    }
}