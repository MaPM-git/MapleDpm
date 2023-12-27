package org.mapledpmlab.type.skill.attackskill.xenon;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.xenon.MeltdownExplosionDebuff;

public class MeltdownExplosion extends AttackSkill {
    public MeltdownExplosion() {
        this.setName("멜트다운 익스플로젼");
        this.setAttackCount(6L * 2);
        this.setDamage(1500.0);
        this.setDelay(3150L);
        this.setRelatedSkill(new MeltdownExplosionDebuff());
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setCooldown(50.0);
        this.addFinalDamage(0.85);          // 버추얼 프로텍션
    }
}
