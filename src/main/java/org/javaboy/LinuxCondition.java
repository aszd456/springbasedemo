package org.javaboy;/**
 * @author leo
 * @date 2021/2/19
 * @apiNote
 */

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Locale;
import java.util.Objects;

/**
 * @ClassName LinuxCondition
 * @Description TODO
 * @Author zhouliansheng
 * @Date 2021/2/19 10:39
 * @Version 1.0
 **/
public class LinuxCondition implements Condition {
    @Override
    public boolean matches(@NotNull ConditionContext conditionContext,
                           @NotNull AnnotatedTypeMetadata annotatedTypeMetadata) {
        return Objects.requireNonNull(conditionContext.getEnvironment().getProperty("os.name"))
                .toLowerCase(Locale.ROOT).contains("linux");
    }
}
