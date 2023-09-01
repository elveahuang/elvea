package cn.elvea.platform.system.tag.controller.admin;

import cn.elvea.platform.commons.core.web.controller.AbstractController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RestController;

/**
 * 标签管理控制器
 *
 * @author elvea
 * @since 0.0.1
 */
@RestController
@Tag(name = "tag-mgr", description = "标签管理控制器")
public class TagAdminController extends AbstractController {
}
