package org.mapledpmlab.type.skill.attackskill.battlemage;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GrimReaperMOD extends AttackSkill {
    public GrimReaperMOD() {
        this.setName("그림 리퍼(마스터 오브 데스)");
        this.setDelay(720L);
        this.setInterval(2000L);
        this.setDotDuration(30000L);
        this.setDamage(1760.0);
        this.setAttackCount(12L);
        this.setCooldown(90.0);
        this.addFinalDamage(1.6);       // 코어 강화
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
