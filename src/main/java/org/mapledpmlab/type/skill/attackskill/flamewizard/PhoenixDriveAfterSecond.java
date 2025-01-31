package org.mapledpmlab.type.skill.attackskill.flamewizard;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PhoenixDriveAfterSecond extends AttackSkill {
    public PhoenixDriveAfterSecond() {
        this.setName("피닉스 드라이브(2, 3, 4타)");
        this.setDamage(1035.0 - 90);    // 오비탈 플레임-스플릿 어택
        this.setAttackCount(2L + 1);    // 오비탈 플레임-스플릿 어택
        this.addIgnoreDefenseList(20L); // 오비탈 플레임-이그노어 가드
        this.addFinalDamage(0.5);
        this.addFinalDamage(2.2);
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.addFinalDamage(1.08);      // 오버로드 마나
    }
}
