package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.kain.DeathBlessingContributionBuff;

public class DeathBlessingAnnihilationIncarnation extends AttackSkill {
    public DeathBlessingAnnihilationIncarnation() {
        this.setName("데스 블레싱(어나일레이션, 인카네이션)");
        this.setDamage(755.0 + 210);
        this.setAttackCount(15L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new DeathBlessingContributionBuff());
    }
}
