package piotrek.k.flats.Model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(RealEstate.class)
public class RealEstate_ {
	public static volatile SingularAttribute<RealEstate, Long> realEstate_id;
	public static volatile SingularAttribute<RealEstate, Boolean> active;
	public static volatile SingularAttribute<RealEstate, Boolean> availableToOtherUsers;
}
