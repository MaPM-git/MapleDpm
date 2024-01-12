package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SpiritClawInstall extends AttackSkill {
    public SpiritClawInstall() {
        this.setName("귀참(정령집속)");
        this.setDamage(475.0);
        this.setDotDuration(810L);
        this.setInterval(810L / 13);
        this.setLimitAttackCount(13L);
        this.setAttackCount(1L);
        //this.setAttackCount(12L + 1);   // 귀참-보너스 어택
        this.setAddDamage(20L + 20);    // 귀참-리인포스, 보스 킬러
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
