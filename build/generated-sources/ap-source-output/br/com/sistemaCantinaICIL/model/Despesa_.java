package br.com.sistemaCantinaICIL.model;

import java.math.BigDecimal;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Despesa.class)
public abstract class Despesa_ {

	public static volatile SingularAttribute<Despesa, EnumSituacao> situacao;
	public static volatile SingularAttribute<Despesa, Calendar> dataPagamento;
	public static volatile SingularAttribute<Despesa, Calendar> dataVencimento;
	public static volatile SingularAttribute<Despesa, BigDecimal> valor;
	public static volatile SingularAttribute<Despesa, String> nome;
	public static volatile SingularAttribute<Despesa, Long> id;
	public static volatile SingularAttribute<Despesa, String> descricao;

}

