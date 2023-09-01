package cn.elvea.platform.system.core.controller.home;

import cn.elvea.platform.commons.core.web.R;
import cn.elvea.platform.commons.core.web.controller.AbstractController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统设置控制器
 *
 * @author elvea
 * @since 0.0.1
 */
@Slf4j
@RestController
@Tag(name = "ConfigController", description = "系统设置控制器")
public class ConfigHomeController extends AbstractController {

    /**
     * 查询单个角色类型
     *
     * @return 查询结果
     */
    @Operation(summary = "用户注册")
    @ApiResponse(description = "用户注册")
    @PostMapping(value = "/attachment/list")
    public R<?> index() {
        return R.success();
    }

}
