package org.mapledpmlab.type.skill.attackskill.flamewizard;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PhoenixDriveAfterSecond extends AttackSkill {
    public PhoenixDriveAfterSecond() {
        this.setName("피닉스 드라이브(2, 3, 4타)");
        this.setDamage(450.0);
        this.setAttackCount(2L);
        this.addFinalDamage(0.5);
        this.addFinalDamage(2.2);
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(240L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
    }
}
