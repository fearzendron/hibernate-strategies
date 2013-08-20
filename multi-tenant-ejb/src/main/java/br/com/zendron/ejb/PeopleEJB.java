package br.com.zendron.ejb;

import javax.ejb.Local;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Zendron
 * Date: 19/08/13
 * Time: 14:14
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface PeopleEJB extends Serializable{

    public void save(PeopleEJB people);

    public void saveWithouPersistContext(PeopleEJB people);

}
