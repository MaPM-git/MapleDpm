package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.kain.DeathBlessingContributionBuff;

public class DeathBlessingAnnihilation extends AttackSkill {
    public DeathBlessingAnnihilation() {
        this.setName("데스 블레싱(어나일레이션)");
        this.setDamage(725.0 + 210);
        this.setAttackCount(10L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new DeathBlessingContributionBuff());
    }
}
