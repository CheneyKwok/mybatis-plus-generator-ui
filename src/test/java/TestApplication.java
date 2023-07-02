import com.github.davidfantasy.mybatisplus.generatorui.GeneratorConfig;
import com.github.davidfantasy.mybatisplus.generatorui.MybatisPlusToolsApplication;
import com.github.davidfantasy.mybatisplus.generatorui.mbp.NameConverter;

public class TestApplication {


    public static void main(String[] args) {
        GeneratorConfig config = GeneratorConfig.builder().jdbcUrl("jdbc:mysql://118.31.224.105:35487/smart_link_engine")
                .userName("sle_dev")
                .password("O*&tyvcaze4")
                .port(8068)
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .basePackage("com.xiangzheng.smartengine")
                //数据库表前缀，生成entity名称时会去掉
                .tablePrefix("t_")
                .nameConverter(new NameConverter() {
                    @Override
                    public String serviceNameConvert(String entityName) {
                        return entityName + "Service";
                    }

                    @Override
                    public String controllerNameConvert(String entityName) {
                        return entityName + "Controller";
                    }
                })
                .build();
        MybatisPlusToolsApplication.run(config);
        System.out.println("http://localhost:" + config.getPort());
    }


}
