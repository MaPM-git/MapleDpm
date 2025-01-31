package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DragonFang extends AttackSkill {
    public DragonFang() {
        this.setName("드래곤 팡");
        this.setDamage(437.0);
        this.setAttackCount(4L);
        //this.setDotDuration(9450L);
        //this.setInterval(1350L);
        //this.setCooldown(13.45);
        this.setDotDuration(8400L);
        this.setInterval(1200L);
        this.setCooldown(11.4);
        this.setLimitAttackCount(7L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyCooldownReduction(false);
    }
}
