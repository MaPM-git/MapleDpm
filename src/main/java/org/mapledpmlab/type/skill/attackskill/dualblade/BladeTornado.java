package org.mapledpmlab.type.skill.attackskill.dualblade;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BladeTornado extends AttackSkill {
    public BladeTornado() {
        this.setName("블레이드 토네이도");
        this.setAttackCount(14L);
        this.setDamage(1320.0);
        this.addIgnoreDefenseList(100L);
        this.setDelay(720L);
        this.setCooldown(12.0);
        this.setApplyFinalAttack(true);
        this.setRelatedSkill(new BladeTornadoTyphoon());
        this.addFinalDamage(1.6);       // 코어 강화
        this.addFinalDamage(0.85);           // 미러 이미징
    }
}
