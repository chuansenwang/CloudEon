package com.data.cloudeon.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TaskType {

    TAG_HOST(1, "添加k8s节点标签", "com.data.cloudeon.processor.TagHostLabelTask", true),
    START_K8S_SERVICE(2, "启动角色k8s服务", "com.data.cloudeon.processor.StartRoleK8sDeploymentTask", false),
    PULL_IMAGE_FROM_REGISTRY_TO_HOST(3, "拉取容器镜像到节点", "com.data.cloudeon.processor.PullImageTask", true),
    INSTALL_ROLE_TO_HOST(4, "安装服务角色到节点", "com.data.cloudeon.processor.InstallTask", true),
    CONFIG_ROLE_TO_HOST(5, "配置服务角色到节点", "com.data.cloudeon.processor.ConfigTask", true),
    INIT_HDFS_NAMENODE(6, "初始化NameNode", "com.data.cloudeon.processor.HdfsZkfcFormatTask", false),
    YARN_HDFS_MKDIR(7, "HDFS上创建目录", "com.data.cloudeon.processor.InitYARNDirOnHDFSTask", false),
    CANCEL_TAG_HOST(8, "移除节点上的标签", "com.data.cloudeon.processor.CancelHostTagTask", true),
    STOP_K8S_SERVICE(9, "停止K8s服务", "com.data.cloudeon.processor.StopRoleK8sDeploymentTask", false),
    REGISTER_BE(10, "注册be节点", "com.data.cloudeon.processor.RegisterBeTask", false),
    REGISTER_PROMETHEUS(11, "注册prometheus采集配置", "com.data.cloudeon.processor.RegisterPrometheusScrapyTask", false),
    DELETE_DATA_DIR(12, "删除服务数据目录", "com.data.cloudeon.processor.DeleteServiceDataDirTask", true),
    DELETE_SERVICE_DB_DATA(13, "删除服务相关db数据库", "com.data.cloudeon.processor.DeleteServiceDBDataTask", false),
    STOP_ROLE_POD(14, "停止角色Pod", "com.data.cloudeon.processor.StopRolePodTask", true),
    SCALE_DOWN_K8S_SERVICE(15, "按规模减少k8s服务", "com.data.cloudeon.processor.ScaleDownK8sServiceTask", false),
    SCALE_UP_K8S_SERVICE(16, "按规模增加k8s服务", "com.data.cloudeon.processor.ScaleUpK8sServiceTask", false),
    UPDATE_SERVICE_STATE(17, "更新服务实例状态", "com.data.cloudeon.processor.UpdateServiceStateTask", false),
    INIT_HIVE_WAREHOUSE(17, "初始化hive仓库文件目录", "com.data.cloudeon.processor.InitHiveWarehouseTask", false),
    INIT_HIVE_METASTORE(18, "初始化hive Metastore", "com.data.cloudeon.processor.InitHiveMetastoreTask", false),



    ;

    private final int code;

    private final String name;

    /**
     * 处理器类
     */
    private final String processorClass;

    private final boolean isHostLoop;

    public static TaskType of(int code) {
        for (TaskType nodeType : values()) {
            if (nodeType.code == code) {
                return nodeType;
            }
        }
        throw new IllegalArgumentException("unknown TaskGroupType of " + code);
    }

}
