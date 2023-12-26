package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.mechanic.SupportWaverHEX;

public class SupportWaverHEXDie extends AttackSkill {
    public SupportWaverHEXDie() {
        this.setName("서포트 웨이버 : H-EX(자폭)");
        this.setCooldown(85.0);
        this.setAttackCount(1L);
        this.setDamage(1100.0);
        this.addFinalDamage(2.11);          // 로봇 마스터리
        this.setRelatedSkill(new SupportWaverHEX());
    }
}
