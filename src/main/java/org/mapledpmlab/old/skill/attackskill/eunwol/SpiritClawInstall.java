package org.mapledpmlab.old.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SpiritClawInstall extends AttackSkill {
    public SpiritClawInstall() {
        this.setName("귀참(정령집속)");
        this.setDamage(475.0);
        this.setAttackCount(12L + 1);   // 귀참-보너스 어택
        this.setAddDamage(20L + 20);    // 귀참-리인포스, 보스 킬러
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(810L);
    }
}
