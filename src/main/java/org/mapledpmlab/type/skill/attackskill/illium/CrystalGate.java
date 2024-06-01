package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.illium.CrystalGateBuff;

public class CrystalGate extends AttackSkill {
    public CrystalGate() {
        this.setName("크리스탈 게이트");
        this.setDamage(990.0);
        this.setAttackCount(5L);
        this.setCooldown(1.5);
        /*this.setDotDuration(190000L);
        this.setInterval(1500L);*/
        this.addFinalDamage(1.6);   // 코어강화
    }
}
