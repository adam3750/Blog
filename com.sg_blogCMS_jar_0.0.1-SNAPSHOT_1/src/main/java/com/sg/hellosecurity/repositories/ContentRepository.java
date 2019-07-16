
package com.sg.hellosecurity.repositories;

import com.sg.hellosecurity.entity.Content;
import com.sg.hellosecurity.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SMD3
 */
@Repository
public interface ContentRepository extends JpaRepository<Content, Integer> {
   @Transactional
    List<Content> deleteByUserid(User user);
}
