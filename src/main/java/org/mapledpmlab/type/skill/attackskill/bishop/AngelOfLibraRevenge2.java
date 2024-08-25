package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AngelOfLibraRevenge2 extends AttackSkill {
    public AngelOfLibraRevenge2() {
        this.setName("엔젤 오브 리브라(복수의 천사)");
        this.setDamage(1100.0);
        this.setAttackCount(10L);
        this.setInterval(3500L);
        this.setDotDuration(32000L);
        this.setAddDamage(-40L);        // 아케인 에임 소환수 미적용
        this.addFinalDamage(1.6);       // 코어강화
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
