package com.knusolution.datahub.article

import com.knusolution.datahub.system.DetailCategoryEntity
import org.jetbrains.annotations.NotNull
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class ArticleEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val articleId: Long=0,

    @NotNull
    @Column
    val uploadDate : LocalDateTime,

    @NotNull
    @Column
    val approval : String,

    @Column
    val declineDetail : String,

    @NotNull
    @Column
    val taskFileUrl : String,

    @NotNull
    @Column
    val taskFileName : String,

    @Column
    val declineFileUrl : String,

    @Column
    val declineFileName : String,

    @ManyToOne(fetch = FetchType.LAZY) // 지연 로딩 설정
    @JoinColumn(name = "detailCategoryId")
    val detailCategoryId:DetailCategoryEntity

    )

fun ArticleDto.asEntity() = ArticleEntity(
    uploadDate = this.uploadDate,
    approval = this.approval,
    declineDetail = this.declineDetail,
    taskFileUrl = this.taskFileUrl,
    taskFileName = this.taskFileName,
    declineFileUrl = this.declineFileUrl,
    declineFileName = this.declineFileName,
    detailCategoryId = this.detailCategoryId
)