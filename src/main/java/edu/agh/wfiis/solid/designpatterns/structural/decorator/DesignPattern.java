package edu.agh.wfiis.solid.designpatterns.structural.decorator;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.MessageFormat;

public class DesignPattern {

    enum Mode {
        OPTIMIZED, DEBUG;
    }

    private static final Log LOGGER = LogFactory.getLog(DesignPattern.class);

    public static Mode MODE;

    private final String name;

    private final RunnableCode patternCode;

    public RunnableCode refactor(String badCode) {
        RunnableCode code = null;
        switch(MODE){
            case OPTIMIZED:
                code =  CodeOptimizer.optimize(patternCode.run(badCode));
                break;
            case DEBUG:
                StopWatch stopWatch = new StopWatch();
                stopWatch.start();
                code = patternCode.run(badCode);
                stopWatch.stop();
                LOGGER.debug(MessageFormat.format("Refactoring took {0} miliseconds", stopWatch.getTime()));
        }
        return code;
    }

    public DesignPattern(String name, RunnableCode patternCode) {
        this.name = name;
        this.patternCode = patternCode;
    }


    public static void main(String args[]) {
        DesignPattern.MODE = Mode.valueOf(args[0]);
        DesignPattern designPattern = new DesignPattern("decorator", new RunnableCode() {
            @Override
            public RunnableCode run(String code) {
                return null;
            }
        });
        designPattern.refactor("public class ClassWithManyResponsibilities...");
    }


}


//required dependencies, put here only to compile project
interface RunnableCode {
    RunnableCode run(String code);
}

class CodeOptimizer {
    public static RunnableCode optimize(RunnableCode run) {
        //even more magic happens here than usual
        return null;
    }
}