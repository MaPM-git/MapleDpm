package org.mapledpmlab.type.skill.attackskill.pathfinder;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AdditionalBlastREFirst extends AttackSkill {
    public AdditionalBlastREFirst() {
        this.setName("에디셔널 블래스트(첫타)");
        this.setAttackCount(3L);
        this.setDamage(401.0);          // 에인션트 아처리
        this.setProp(60L);              // 카디널 포스-에디셔널 인핸스
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new AdditionalBlastREAfterSecond());
    }
}
