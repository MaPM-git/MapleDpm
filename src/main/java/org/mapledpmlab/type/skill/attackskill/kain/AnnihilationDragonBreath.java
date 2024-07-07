package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.kain.AnnihilationBuff;

public class AnnihilationDragonBreath extends AttackSkill {
    public AnnihilationDragonBreath() {
        this.setName("어나일레이션(마룡의 숨결)");
        this.setAttackCount(15L);
        this.setDamage(1320.0);
        this.setCooldown(0.25);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(50L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
    }
}
