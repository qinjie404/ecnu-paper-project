package ${package.Mapper};

import org.springframework.stereotype.Repository;
import ${superMapperClassPackage};

/**
* Mapper - ${table.comment!}
* ============================================================================
* 版权所有 ${cfg.year} 。
*
* @author ${author}
* @version 1.0 ${date}
* ============================================================================
*/
@Repository
public interface ${table.mapperName} extends ${superMapperClass}<${entity}>{

}