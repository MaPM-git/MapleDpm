package org.mapledpmlab.type.skill.attackskill.dualblade;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BladeTornadoTyphoon extends AttackSkill {
    public BladeTornadoTyphoon() {
        this.setName("블레이드 토네이도(태풍)");
        this.setDamage(880.0);
        this.setAttackCount(12L);
        this.setDotDuration(720L);
        this.setInterval(120L);
        this.setLimitAttackCount(6L);
        this.addIgnoreDefenseList(100L);
        this.addFinalDamage(1.6);           // 코어강화
        this.setApplyFinalAttack(true);
        this.addFinalDamage(0.85);           // 미러 이미징
    }
}
