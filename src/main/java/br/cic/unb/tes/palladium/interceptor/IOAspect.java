package br.cic.unb.tes.palladium.interceptor;

import org.jboss.aop.Aspect;
import org.jboss.aop.Bind;
import org.jboss.aop.joinpoint.Invocation;

import br.cic.unb.tes.palladium.io.NullInputStream;
import br.cic.unb.tes.palladium.io.NullOutputStream;


@Aspect
public class IOAspect {
	
	@Bind(pointcut="call(* instanceof java.io.inputStream->new(..))")
	public Object newInputStreamAdvice(Invocation invocation){
		return new NullInputStream();
	}
	
	@Bind(pointcut="call(* java.io.inputStream->new(..))")
	public Object newOutputStreamAdvice(Invocation invocation){
		return new NullOutputStream();
	}	
}