package org.mapledpmlab.type.skill.attackskill.xenon;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PhotonRay extends AttackSkill {
    public PhotonRay() {
        this.setName("포톤 레이");
        this.setAttackCount(4L * 2);
        this.setDamage(880.0);
        this.setDotDuration(900L);
        this.setInterval(30L);
        this.setLimitAttackCount(30L);
        this.setCooldown(30.0);
        this.addFinalDamage(1.6);           // 코어 강화
        this.addFinalDamage(0.85);          // 버추얼 프로텍션
    }
}
