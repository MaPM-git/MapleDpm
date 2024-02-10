package org.mapledpmlab.type.skill.attackskill.cannonshooter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SupportMonkeyTwins extends AttackSkill {
    public SupportMonkeyTwins() {
        this.setName("서포트 몽키 트윈스");
        this.setDamage(303.0);
        this.setAttackCount(2L);        // 서포트 몽키 트윈스-스플릿 데미지
        this.setCooldown(60.0);
        this.setDotDuration(60000L);
        this.setInterval(312L);         // 서포트 몽키 트윈스-인핸스
        this.addFinalDamage(0.6);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
