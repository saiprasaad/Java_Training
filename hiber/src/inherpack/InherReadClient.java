package inherpack;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import utility.HibernateUtility;
public class InherReadClient {
	public static void main(String[] args) {
		Session session=HibernateUtility.getSession();
		
		Query query=session.createQuery("from ShoeFactory");
		Criteria cr ;
		List list=session.createCriteria(ShoeFactory.class).add(Restrictions.sqlRestriction("? = case when class='inherpack.BataShoeFactory' then bataName end"))
				 .list();
	
		System.out.println(list);
//		Iterator iter=list.iterator();
////		
//		while(iter.hasNext()) {
//			System.out.println(iter.next().getClass());
//		}
//			Object factory=iter.next();
//			//System.out.println(factory.getSid()+":"+factory.getName());
//			if(factory instanceof BataShoeFactory) {
//				BataShoeFactory bsf=(BataShoeFactory)factory;
//				System.out.println(bsf.getSid()+":"+bsf.getName()+":"+bsf.getBataName());
//			}
//			else if(factory instanceof LakhaniShoeFactory) {
////				Lakhani
//			}
//		}
	}
}