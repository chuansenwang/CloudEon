import { ProDescriptions } from '@ant-design/pro-components';
import { Image, Spin } from 'antd';
import styles from './index.less'
import { statusColor,serviceStatusColor } from '@/utils/colonyColor'// '../../../../../../utils/colonyColor'

const statusTab:React.FC<{statusInfo: API.serviceInfos, dashboardUrl:string, loading: boolean}> = ({statusInfo,dashboardUrl, loading}) => {
    
    return (
        <div className={styles.statusTabLayout}>
            <Spin tip="Loading" size="small" spinning={!!loading}>
            <div className={styles.statusBar}>
                <div className={styles.leftBox}>
                    <div>
                        <div>服务实例名：</div>
                        <div>{statusInfo.name}</div>
                    </div>
                    <div>
                        <div>框架服务名：</div>
                        <div>{statusInfo.stackServiceName}</div>
                    </div>
                    <div>
                        <div>版本：</div>
                        <div>{statusInfo.version}</div>
                    </div>
                    <div>
                        <div>dockerImage：</div>
                        <div>{statusInfo.dockerImage}</div>
                    </div>
                    <div>
                        <div>服务描述：</div>
                        <div>{statusInfo.stackServiceDesc}</div>
                    </div>
                </div>
                <div className={styles.rightBox}>
                    <div style={{whiteSpace: 'nowrap'}}> 
                        <div>服务状态：</div>
                        <div className={styles.statusTitle}>
                            <span style={{backgroundColor: serviceStatusColor[statusInfo.serviceStateValue || 0]}} 
                                className={styles.statusCircel}>
                            </span>
                            {statusInfo.serviceState}
                        </div>
                    </div>
                </div>
            </div>
            <div className={styles.dashboardWrap}>
                <iframe style={{border:0, width:'100%',height:'100%'}} src={dashboardUrl} ></iframe>
            </div>
            </Spin>
        </div>
    )
}

export default statusTab;