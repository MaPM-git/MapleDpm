package org.mapledpmlab.type.skill.attackskill.nightlord;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FourSeasonsRamphantAnnihilation extends AttackSkill {
    public FourSeasonsRamphantAnnihilation() {
        this.setName("포 시즌 : 램펀트(섬멸)");
        this.setApplyFinalAttack(true);
        this.setAttackCount(7L * 2);
        this.setDamage(790.0);
        this.setDelayByAttackSpeed(840L);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(0.85);      // 쉐도우 파트너
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
    }
}
