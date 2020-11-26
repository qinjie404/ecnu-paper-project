package com.ecnu.edu.petgenerator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * 代码生成器 - Mysql示例
 * ============================================================================
 * 版权所有 2019 。
 *
 * @author qinjie
 * @version 1.0 2019-11-12 。
 * ============================================================================
 */
public class PetGeneratorApplication {

    /**
     * 读取控制台内容
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {

        /**
         * 代码生成器
         */
        AutoGenerator mpg = new AutoGenerator();

        /**
         * 全局配置
         */
        GlobalConfig gc = new GlobalConfig();
//        String projectPath = System.getProperty("user.dir");
        // 输出路径
        gc.setOutputDir("E:\\generator");
        // 作者
        gc.setAuthor("qinjie");
        gc.setOpen(false);
        gc.setSwagger2(true);
        // 自定义实体类命名规则
        gc.setEntityName("%sDO");
        gc.setDateType(DateType.ONLY_DATE);
        // 自定义Service类命名规则
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        //自定义mapper曾类命名规则
        gc.setMapperName("%sDao");
        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);

        /**
         * 数据源配置DataSourceConfig
         */
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/pet?useUnicode=true&serverTimezone=GMT&useSSL=false&characterEncoding=utf8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        /**
         * 包配置PackageConfig
         */
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName(scanner("模块名"));
        // 包主路径
        pc.setParent("");
        // 自定义实体类包路径
        pc.setEntity("entity.domain");
        // 自定义Service路径
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("dao");
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                /*
                自定义属性注入: 模板配置：year=${cfg.xxx}
                 */
                Map<String, Object> map = new HashMap<>(1);
                map.put("year", String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
                map.put("superEntityClassPackage",getConfig().getStrategyConfig().getSuperEntityClass());
                this.setMap(map);
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return "E:\\generator\\" + tableInfo.getMapperName() + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        /**
         * 策略配置StrategyConfig
         */
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //strategy.setSuperEntityClass("");
        strategy.setEntityLombokModel(true);
        strategy.setInclude(scanner("表名"));
        // 忽略父类属性
        strategy.setSuperEntityColumns("create_time", "create_id", "update_time", "update_id", "status");
        // 默认表前缀
        strategy.setTablePrefix("pet_");
        strategy.setSuperEntityClass("com.ecnu.edu.petapibase.common.entity.BaseDataDO");
        strategy.setSuperMapperClass("com.ecnu.edu.petapibase.common.dao.BaseDao");
        strategy.setSuperServiceClass("com.ecnu.edu.petapibase.common.service.BaseService");
        strategy.setSuperServiceImplClass("com.ecnu.edu.petapibase.common.service.impl.BaseServiceImpl");
//        strategy.setSuperControllerClass("");
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        /**
         * 自定义模板TemplateConfig
         */
        TemplateConfig templateConfig = new TemplateConfig()
                .setEntity("/templates/entity.java")
                .setMapper("/templates/mapper.java")
                .setService("/templates/service.java")
                .setServiceImpl("/templates/serviceImpl.java")
                .setController("/templates/controller.java")
                .setXml(null);
        mpg.setTemplate(templateConfig);
        mpg.execute();
    }

}
