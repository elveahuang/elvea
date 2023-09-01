package cn.elvea.platform.system.commons.web;

import cn.elvea.platform.commons.core.annotations.OperationLog;
import cn.elvea.platform.commons.core.constants.GlobalConstants;
import cn.elvea.platform.commons.core.web.R;
import cn.elvea.platform.commons.core.web.controller.AbstractController;
import com.google.common.collect.Maps;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.Map;

import static cn.elvea.platform.system.commons.constants.SystemMappingConstants.API_V1_INITIALIZE;

/**
 * DefaultController
 *
 * @author elvea
 * @since 0.0.1
 */
@Controller
@Tag(name = "DefaultController", description = "默认控制器")
public class DefaultController extends AbstractController {

    /**
     * 应用初始化
     *
     * @return 应用版本号
     */
    @Operation(summary = "应用初始化")
    @ApiResponse(description = "应用初始化")
    @ResponseBody
    @GetMapping(API_V1_INITIALIZE)
    @OperationLog("应用初始化")
    public R<?> initialize() {
        Map<String, Object> data = Maps.newLinkedHashMap();
        data.put("version", GlobalConstants.VERSION);
        data.put("now", LocalDateTime.now());
        return R.success(data);
    }

    /**
     * 获取当前应用版本
     *
     * @return 应用版本号
     */
    @Operation(summary = "默认控制器")
    @ApiResponse(description = "当前应用版本号")
    @ResponseBody
    @GetMapping("/api/version")
    @OperationLog("获取当前应用版本")
    public R<?> version() {
        Map<String, Object> data = Maps.newLinkedHashMap();
        data.put("version", GlobalConstants.VERSION);
        data.put("now", LocalDateTime.now());
        return R.success(data);
    }

}
