package org.mapledpmlab.type.skill.attackskill.flamewizard;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PhoenixDriveFirst extends AttackSkill {
    public PhoenixDriveFirst() {
        this.setName("피닉스 드라이브(1타)");
        this.setDelay(240L);
        this.setDamage(450.0);
        this.setAttackCount(2L);
        this.addFinalDamage(2.2);
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new PhoenixDriveAfterSecond());
        this.getMultiAttackInfo().add(120L);
        this.addFinalDamage(1.08);      // 오버로드 마나
    }
}
